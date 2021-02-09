package com.customshop.back.model.utils;

import com.customshop.back.auth.security.jwt.JwtTokenProvider;
import com.customshop.back.model.entity.auditable.AuditableEnteredBy;
import com.customshop.back.model.entity.auditable.AuditableSession;
import com.customshop.back.model.web.filter.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class PersistAuditEntityService {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void upsert(Object entity) {

        if (entity != null) {
            if (entity instanceof AuditableSession) {
                fillAuditableSessionFields((AuditableSession) entity);
            }
            if (entity instanceof AuditableEnteredBy) {
                fillAuditableEnteredByFields((AuditableEnteredBy) entity);
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
                if (entity instanceof AuditableEnteredBy) {
                    fillAuditableEnteredByFields((AuditableEnteredBy) entity);
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
            auditableSession.setCreateSessionTokenId(authToken);
            auditableSession.setUpdateSessionTokenId(authToken);
        } else {
            auditableSession.setUpdateDateTimeUtc(auditableSession.getCreateDateTimeUtc());
            auditableSession.setUpdateSessionTokenId(authToken);
        }
    }

    private void fillAuditableEnteredByFields(AuditableEnteredBy auditableEnteredBy) {
        String username = RequestContext.get(RequestContext.AUTH_TOKEN) != null
                ? jwtTokenProvider.getUsername(RequestContext.get(RequestContext.AUTH_TOKEN).toString())
                : "";

        if (auditableEnteredBy.getCreatedByAdmin() == null) {
            auditableEnteredBy.setCreatedByAdmin(username);
            auditableEnteredBy.setUpdatedByAdmin(username);
        } else {
            auditableEnteredBy.setUpdatedByAdmin(username);
        }
    }

}
