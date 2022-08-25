package noticeboard.entity.freeboard;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QfreeCommit is a Querydsl query type for freeCommit
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QfreeCommit extends EntityPathBase<freeCommit> {

    private static final long serialVersionUID = -707710078L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QfreeCommit freeCommit = new QfreeCommit("freeCommit");

    public final QpostBaseEntity _super = new QpostBaseEntity(this);

    //inherited
    public final StringPath content = _super.content;

    public final QfreePost freepost;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.util.Date> posttime = _super.posttime;

    //inherited
    public final StringPath writer = _super.writer;

    public QfreeCommit(String variable) {
        this(freeCommit.class, forVariable(variable), INITS);
    }

    public QfreeCommit(Path<? extends freeCommit> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QfreeCommit(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QfreeCommit(PathMetadata<?> metadata, PathInits inits) {
        this(freeCommit.class, metadata, inits);
    }

    public QfreeCommit(Class<? extends freeCommit> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.freepost = inits.isInitialized("freepost") ? new QfreePost(forProperty("freepost"), inits.get("freepost")) : null;
    }

}

