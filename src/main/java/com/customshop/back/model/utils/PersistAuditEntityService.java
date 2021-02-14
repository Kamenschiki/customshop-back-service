package com.customshop.back.model.utils;

import com.customshop.back.model.entity.Detailed;
import com.customshop.back.model.entity.auditable.AuditableSession;
import com.customshop.back.model.web.filter.RequestContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class PersistAuditEntityService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void upsert(Object entity) {

        if (entity != null) {
            if (entity instanceof AuditableSession) {
                fillAuditableSessionFields((AuditableSession) entity);
            }
            if(entity instanceof Detailed){
                ((Detailed<?>) entity).getDetails().forEach(this::fillAuditableSessionFields);
            }
            entityManager.persist(entity);
        }
    }

    @Transactional
    public void upsertAll(List<Object> entities) {

        entities.forEach(entity -> {
            if (entity != null) {
                if (entity instanceof AuditableSession) {
                    fillAuditableSessionFields((AuditableSession) entity);
                }
                //TODO: find better solution to walk through aggregated entities
                if(entity instanceof Detailed){
                    ((Detailed<?>) entity).getDetails().forEach(this::fillAuditableSessionFields);
                }
            }
        });
        entities.forEach(entity -> {
            entityManager.persist(entity);
        });
    }

    private void fillAuditableSessionFields(AuditableSession auditableSession) {
        String authToken = RequestContext.get(RequestContext.AUTH_TOKEN) != null
                ? RequestContext.get(RequestContext.AUTH_TOKEN).toString()
                : "";
        if (auditableSession.getCreateDateTimeUtc() == null) {
            auditableSession.setCreateDateTimeUtc(TimestampUtils.getCurrentTimestamp());
            auditableSession.setUpdateDateTimeUtc(auditableSession.getCreateDateTimeUtc());
            auditableSession.setCreateJwtToken(authToken);
            auditableSession.setUpdateJwtToken(authToken);
        } else {
            auditableSession.setUpdateDateTimeUtc(TimestampUtils.getCurrentTimestamp());
            auditableSession.setUpdateJwtToken(authToken);
        }
    }
}
