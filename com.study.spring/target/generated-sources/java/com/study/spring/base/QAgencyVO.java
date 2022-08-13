package com.study.spring.base;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAgencyVO is a Querydsl query type for AgencyVO
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAgencyVO extends EntityPathBase<AgencyVO> {

    private static final long serialVersionUID = -1982524020L;

    public static final QAgencyVO agencyVO = new QAgencyVO("agencyVO");

    public final StringPath agency = createString("agency");

    public final ListPath<MemberVO, QMemberVO> member = this.<MemberVO, QMemberVO>createList("member", MemberVO.class, QMemberVO.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> posttime = createDateTime("posttime", java.util.Date.class);

    public final StringPath userId = createString("userId");

    public QAgencyVO(String variable) {
        super(AgencyVO.class, forVariable(variable));
    }

    public QAgencyVO(Path<? extends AgencyVO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAgencyVO(PathMetadata<?> metadata) {
        super(AgencyVO.class, metadata);
    }

}

