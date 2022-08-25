package noticeboard.entity.freeboard;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QpostBaseEntity is a Querydsl query type for postBaseEntity
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QpostBaseEntity extends EntityPathBase<postBaseEntity> {

    private static final long serialVersionUID = 31912979L;

    public static final QpostBaseEntity postBaseEntity = new QpostBaseEntity("postBaseEntity");

    public final StringPath content = createString("content");

    public final DateTimePath<java.util.Date> posttime = createDateTime("posttime", java.util.Date.class);

    public final StringPath writer = createString("writer");

    public QpostBaseEntity(String variable) {
        super(postBaseEntity.class, forVariable(variable));
    }

    public QpostBaseEntity(Path<? extends postBaseEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QpostBaseEntity(PathMetadata<?> metadata) {
        super(postBaseEntity.class, metadata);
    }

}

