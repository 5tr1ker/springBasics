package noticeboard.entity.freeboard;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QfreeAttach is a Querydsl query type for freeAttach
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QfreeAttach extends EntityPathBase<freeAttach> {

    private static final long serialVersionUID = -760153968L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QfreeAttach freeAttach = new QfreeAttach("freeAttach");

    public final StringPath changedFile = createString("changedFile");

    public final StringPath filename = createString("filename");

    public final NumberPath<Long> fileSize = createNumber("fileSize", Long.class);

    public final QfreePost freepost;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QfreeAttach(String variable) {
        this(freeAttach.class, forVariable(variable), INITS);
    }

    public QfreeAttach(Path<? extends freeAttach> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QfreeAttach(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QfreeAttach(PathMetadata<?> metadata, PathInits inits) {
        this(freeAttach.class, metadata, inits);
    }

    public QfreeAttach(Class<? extends freeAttach> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.freepost = inits.isInitialized("freepost") ? new QfreePost(forProperty("freepost"), inits.get("freepost")) : null;
    }

}

