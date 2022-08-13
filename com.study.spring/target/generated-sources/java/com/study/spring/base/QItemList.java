package com.study.spring.base;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QItemList is a Querydsl query type for ItemList
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QItemList extends EntityPathBase<ItemList> {

    private static final long serialVersionUID = 2021046879L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QItemList itemList = new QItemList("itemList");

    public final com.study.spring.base.item.QfoodItem foodit;

    public final StringPath ItemName = createString("ItemName");

    public final StringPath orderID = createString("orderID");

    public QItemList(String variable) {
        this(ItemList.class, forVariable(variable), INITS);
    }

    public QItemList(Path<? extends ItemList> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QItemList(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QItemList(PathMetadata<?> metadata, PathInits inits) {
        this(ItemList.class, metadata, inits);
    }

    public QItemList(Class<? extends ItemList> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodit = inits.isInitialized("foodit") ? new com.study.spring.base.item.QfoodItem(forProperty("foodit")) : null;
    }

}

