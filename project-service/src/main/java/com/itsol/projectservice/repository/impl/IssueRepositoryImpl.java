package com.itsol.projectservice.repository.impl;

import ch.qos.logback.classic.db.SQLBuilder;
import com.itsol.projectservice.dto.IssueDto;
import com.itsol.projectservice.dto.request.SearchIssueDto;
import com.itsol.projectservice.repository.IssueRepositoryCustom;
import com.itsol.projectservice.utils.HibernateUtil;
import com.itsol.projectservice.utils.PageBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.persistence.TemporalType;
import java.util.List;

public class IssueRepositoryImpl implements IssueRepositoryCustom {
    private static final Logger logger = LogManager.getLogger(IssueRepositoryImpl.class);

    @Override
    public Page<IssueDto> getListByParams(SearchIssueDto requestDto) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            StringBuilder sb = new StringBuilder();
            sb.append("select i.id id, i.name name,i.due_date dueDate,i.priority priority,i.start_date startDate,i.done_percent donePercent, ");
            sb.append(" i.reason reason,i.description description,i.type type,i.project_id projectId,i.status_id statusId from issue i where 1 = 1 ");
            if (requestDto.getName() != null && !requestDto.getName().isEmpty()) {
                sb.append(" and i.name LIKE :I_name ");
            }
            if (requestDto.getProjectId() != 0) {
                sb.append(" and i.project_id=:I_project ");
            }
            if (requestDto.getPriority() != null && !requestDto.getPriority().isEmpty()) {
                sb.append(" and i.priority = :I_priority ");
            }
            if(requestDto.getStartDate() != null){
                sb.append("and i.start_date >= ?1 and i.start_date  <= ?2 ");
            }
            SQLQuery query = session.createSQLQuery(sb.toString());

            if (requestDto.getName() != null && !requestDto.getName().isEmpty()) {
                query.setParameter("I_name", "%" +
                        requestDto.getName().trim()
//                                .substring(1, requestDto.getName().length())
//                                .replace("\\", "\\\\")
//                                .replaceAll("%", "\\%")
//                                .replaceAll("_", "\\_")
                        + "%");
            }
            if (requestDto.getProjectId() != 0) {
                query.setParameter("I_project", requestDto.getProjectId());
            }
            if (requestDto.getPriority() != null && !requestDto.getPriority().isEmpty()) {
                query.setParameter("I_priority", requestDto.getPriority().trim());
            }
            if(requestDto.getStartDate() != null){
                query.setParameter(1,requestDto.getStartDate(),TemporalType.TIMESTAMP)
                        .setParameter(2,requestDto.getEndDate(),TemporalType.TIMESTAMP);
            }

            query.addScalar("id", new LongType());
            query.addScalar("name", new StringType());
            query.addScalar("dueDate", new DoubleType());
            query.addScalar("priority", new StringType());
            query.addScalar("startDate", new DateType());
            query.addScalar("donePercent", new LongType());
            query.addScalar("reason", new StringType());
            query.addScalar("description", new StringType());
            query.addScalar("type", new StringType());
            query.addScalar("projectId", new LongType());
            query.addScalar("statusId", new LongType());

            query.setResultTransformer(Transformers.aliasToBean(IssueDto.class));
            int count = 0;
            List<IssueDto> list = query.list();
            if (list.size() > 0) {
                count = query.getResultList().size();
            }
            System.out.println("count :" + count);
            System.out.println("list :" + list);
            if (requestDto.getPage() != null && requestDto.getPageSize() != null) {
                Pageable pageable = PageRequest.of((requestDto.getPage()+1), requestDto.getPageSize());
//                if (pageable != null) {
//                    query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
//                    query.setMaxResults(pageable.getPageSize());
//                }
//                List<IssueDto> data = query.list();
                Page<IssueDto> dataPage = new PageImpl<>(list, pageable, count);
                return dataPage;
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        } finally {
            session.close();
        }

        return null;
    }
}
