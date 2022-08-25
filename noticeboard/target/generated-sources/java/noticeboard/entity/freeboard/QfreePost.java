package noticeboard.entity.freeboard;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QfreePost is a Querydsl query type for freePost
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QfreePost extends EntityPathBase<freePost> {

    private static final long serialVersionUID = -1278559829L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QfreePost freePost = new QfreePost("freePost");

    public final QpostBaseEntity _super = new QpostBaseEntity(this);

    public final BooleanPath blockcomm = createBoolean("blockcomm");

    //inherited
    public final StringPath content = _super.content;

    public final ListPath<freeAttach, QfreeAttach> freeAttach = this.<freeAttach, QfreeAttach>createList("freeAttach", freeAttach.class, QfreeAttach.class, PathInits.DIRECT2);

    public final ListPath<freeCommit, QfreeCommit> freeCommit = this.<freeCommit, QfreeCommit>createList("freeCommit", freeCommit.class, QfreeCommit.class, PathInits.DIRECT2);

    public final ListPath<freeTag, QfreeTag> freetag = this.<freeTag, QfreeTag>createList("freetag", freeTag.class, QfreeTag.class, PathInits.DIRECT2);

    public final ListPath<freeWhoLike, QfreeWhoLike> freewholike = this.<freeWhoLike, QfreeWhoLike>createList("freewholike", freeWhoLike.class, QfreeWhoLike.class, PathInits.DIRECT2);

    public final NumberPath<Long> ID_numbers = createNumber("ID_numbers", Long.class);

    public final noticeboard.entity.userdata.Qidinfo idinfo;

    public final NumberPath<Integer> likes = createNumber("likes", Integer.class);

    public final NumberPath<Long> numbers = createNumber("numbers", Long.class);

    //inherited
    public final DateTimePath<java.util.Date> posttime = _super.posttime;

    public final BooleanPath privates = createBoolean("privates");

    public final StringPath title = createString("title");

    public final NumberPath<Integer> views = createNumber("views", Integer.class);

    //inherited
    public final StringPath writer = _super.writer;

    public QfreePost(String variable) {
        this(freePost.class, forVariable(variable), INITS);
    }

    public QfreePost(Path<? extends freePost> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QfreePost(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QfreePost(PathMetadata<?> metadata, PathInits inits) {
        this(freePost.class, metadata, inits);
    }

    public QfreePost(Class<? extends freePost> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.idinfo = inits.isInitialized("idinfo") ? new noticeboard.entity.userdata.Qidinfo(forProperty("idinfo"), inits.get("idinfo")) : null;
    }

}

