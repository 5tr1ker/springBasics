package noticeboard.entity.freeboard;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QfreeWhoLike is a Querydsl query type for freeWhoLike
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QfreeWhoLike extends EntityPathBase<freeWhoLike> {

    private static final long serialVersionUID = -93511798L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QfreeWhoLike freeWhoLike = new QfreeWhoLike("freeWhoLike");

    public final QfreePost freepost;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath recommender = createString("recommender");

    public QfreeWhoLike(String variable) {
        this(freeWhoLike.class, forVariable(variable), INITS);
    }

    public QfreeWhoLike(Path<? extends freeWhoLike> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QfreeWhoLike(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QfreeWhoLike(PathMetadata<?> metadata, PathInits inits) {
        this(freeWhoLike.class, metadata, inits);
    }

    public QfreeWhoLike(Class<? extends freeWhoLike> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.freepost = inits.isInitialized("freepost") ? new QfreePost(forProperty("freepost"), inits.get("freepost")) : null;
    }

}

