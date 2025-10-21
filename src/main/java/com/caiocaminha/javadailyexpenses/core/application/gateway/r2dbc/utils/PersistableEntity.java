//package com.caiocaminha.javadailyexpenses.core.application.gateway.r2dbc.utils;
//
//import com.google.cloud.Timestamp;
//import lombok.Data;
//import org.springframework.data.domain.Persistable;
//
//import java.io.Serializable;
//
//
////For a class extends an interface we use implements
////For an Interface extend an interface we use extends
//// implements is only from Class to Interface
//@Data
//public abstract class PersistableEntity<T> implements Serializable, Persistable<T> {
//    public Timestamp createdAt;
//    public Timestamp updatedAt;
//
//    @Override
//    public boolean isNew(){
//        return createdAt == updatedAt;
//    }
//
//    void updated() {
//        this.updatedAt = Timestamp.now();
//    }
//}
