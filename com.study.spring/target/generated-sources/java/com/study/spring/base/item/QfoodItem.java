package com.study.spring.base.item;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QfoodItem is a Querydsl query type for foodItem
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QfoodItem extends EntityPathBase<foodItem> {

    private static final long serialVersionUID = -888855074L;

    public static final QfoodItem foodItem = new QfoodItem("foodItem");

    public final QItem _super = new QItem(this);

    public final NumberPath<Integer> calorie = createNumber("calorie", Integer.class);

    //inherited
    public final NumberPath<Integer> count = _super.count;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath maker = createString("maker");

    //inherited
    public final StringPath name = _super.name;

    public QfoodItem(String variable) {
        super(foodItem.class, forVariable(variable));
    }

    public QfoodItem(Path<? extends foodItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QfoodItem(PathMetadata<?> metadata) {
        super(foodItem.class, metadata);
    }

}

