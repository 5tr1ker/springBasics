package noticeboard.entity.userdata;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * Qidinfo is a Querydsl query type for idinfo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class Qidinfo extends EntityPathBase<idinfo> {

    private static final long serialVersionUID = 572431671L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qidinfo idinfo = new Qidinfo("idinfo");

    public final ListPath<noticeboard.entity.freeboard.freePost, noticeboard.entity.freeboard.QfreePost> freepost = this.<noticeboard.entity.freeboard.freePost, noticeboard.entity.freeboard.QfreePost>createList("freepost", noticeboard.entity.freeboard.freePost.class, noticeboard.entity.freeboard.QfreePost.class, PathInits.DIRECT2);

    public final StringPath id = createString("id");

    public final DatePath<java.util.Date> joindate = createDate("joindate", java.util.Date.class);

    public final StringPath password = createString("password");

    public final QprofileSetting profileSetting;

    public Qidinfo(String variable) {
        this(idinfo.class, forVariable(variable), INITS);
    }

    public Qidinfo(Path<? extends idinfo> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public Qidinfo(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public Qidinfo(PathMetadata<?> metadata, PathInits inits) {
        this(idinfo.class, metadata, inits);
    }

    public Qidinfo(Class<? extends idinfo> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.profileSetting = inits.isInitialized("profileSetting") ? new QprofileSetting(forProperty("profileSetting")) : null;
    }

}

