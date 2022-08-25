package com.example.demo.callbacks;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class MyListener {

    private static Log log = LogFactory.getLog(MyListener.class);

    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(ToListen entity) {
        if (entity.getId() == null) {
            log.info("[AUDIT] About to add a entity");
        } else {
            log.info("[AUDIT] About to update/delete entity: " + entity.getId());
        }
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(ToListen entity) {
        log.info("[AUDIT] add/update/delete complete for entity: " + entity.getId());
    }

    @PostLoad
    private void afterLoad(ToListen entity) {
        log.info("[AUDIT] entity loaded from database: " + entity.getId());
    }
    
}
