package noticeboard.entity.userdata;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QprofileSetting is a Querydsl query type for profileSetting
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QprofileSetting extends EntityPathBase<profileSetting> {

    private static final long serialVersionUID = -1415446699L;

    public static final QprofileSetting profileSetting = new QprofileSetting("profileSetting");

    public final StringPath email = createString("email");

    public final NumberPath<Integer> option1 = createNumber("option1", Integer.class);

    public final NumberPath<Integer> option2 = createNumber("option2", Integer.class);

    public final StringPath phone = createString("phone");

    public final NumberPath<Long> profileNumber = createNumber("profileNumber", Long.class);

    public QprofileSetting(String variable) {
        super(profileSetting.class, forVariable(variable));
    }

    public QprofileSetting(Path<? extends profileSetting> path) {
        super(path.getType(), path.getMetadata());
    }

    public QprofileSetting(PathMetadata<?> metadata) {
        super(profileSetting.class, metadata);
    }

}

