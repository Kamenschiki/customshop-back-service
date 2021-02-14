SELECT
    USER_ID AS userId,
    NAME AS userName
FROM USERS AS U
    WHERE (:userName IS NULL OR :userName = U.NAME)
    AND (:email IS NULL OR :email = U.EMAIL)
    AND (:auditableStatus IS NULL OR :auditableStatus = U.AUDITABLE_STATUS)
    AND (:createdAfter IS NULL OR :createdAfter >= U.CREATE_DATE_TIME_UTC)
    AND (:createdBefore IS NULL OR :createdBefore <= U.CREATE_DATE_TIME_UTC)
    AND (:lastUpdatedAfter IS NULL OR :lastUpdatedAfter >= U.UPDATE_DATE_TIME_UTC)
    AND (:lastUpdatedBefore IS NULL OR :lastUpdatedBefore <= U.UPDATE_DATE_TIME_UTC)