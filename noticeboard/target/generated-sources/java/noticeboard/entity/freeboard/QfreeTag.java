package noticeboard.entity.freeboard;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QfreeTag is a Querydsl query type for freeTag
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QfreeTag extends EntityPathBase<freeTag> {

    private static final long serialVersionUID = -1980903121L;

    public static final QfreeTag freeTag = new QfreeTag("freeTag");

    public final ListPath<freePost, QfreePost> freepost = this.<freePost, QfreePost>createList("freepost", freePost.class, QfreePost.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath tagData = createString("tagData");

    public QfreeTag(String variable) {
        super(freeTag.class, forVariable(variable));
    }

    public QfreeTag(Path<? extends freeTag> path) {
        super(path.getType(), path.getMetadata());
    }

    public QfreeTag(PathMetadata<?> metadata) {
        super(freeTag.class, metadata);
    }

}

