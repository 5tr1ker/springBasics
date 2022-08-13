package com.study.spring.base.item;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * Qgame is a Querydsl query type for game
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class Qgame extends EntityPathBase<game> {

    private static final long serialVersionUID = 491160511L;

    public static final Qgame game = new Qgame("game");

    public final QItem _super = new QItem(this);

    //inherited
    public final NumberPath<Integer> count = _super.count;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    public final NumberPath<Integer> useAge = createNumber("useAge", Integer.class);

    public Qgame(String variable) {
        super(game.class, forVariable(variable));
    }

    public Qgame(Path<? extends game> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qgame(PathMetadata<?> metadata) {
        super(game.class, metadata);
    }

}

