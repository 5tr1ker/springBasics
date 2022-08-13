package com.study.spring.base;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QOrderData is a Querydsl query type for OrderData
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QOrderData extends EntityPathBase<OrderData> {

    private static final long serialVersionUID = -5097014L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderData orderData = new QOrderData("orderData");

    public final QItemList itemvo;

    public final QMemberVO mvo;

    public QOrderData(String variable) {
        this(OrderData.class, forVariable(variable), INITS);
    }

    public QOrderData(Path<? extends OrderData> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOrderData(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOrderData(PathMetadata<?> metadata, PathInits inits) {
        this(OrderData.class, metadata, inits);
    }

    public QOrderData(Class<? extends OrderData> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.itemvo = inits.isInitialized("itemvo") ? new QItemList(forProperty("itemvo"), inits.get("itemvo")) : null;
        this.mvo = inits.isInitialized("mvo") ? new QMemberVO(forProperty("mvo"), inits.get("mvo")) : null;
    }

}

