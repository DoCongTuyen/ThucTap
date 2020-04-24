//package com.itsol.projectservice.dao.impl;
//
//import com.itsol.projectservice.dto.IssueDto;
//import com.itsol.projectservice.repository.IssueRepository;
//import com.itsol.projectservice.utils.HibernateUtil;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.NativeQuery;
//import org.springframework.stereotype.Repository;
//
//
//import java.util.List;
//@Repository
//public class IssueRepositoryImpl implements IssueRepository {
//
//    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//
//    @Override
//    public List<IssueDto> get() {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        String sql="select a  from Issue a";
//        NativeQuery<IssueDto> query = session.createSQLQuery(sql);
////        query.addScalar("name", new StringType());
////        query.setResultTransformer(Transformers.aliasToBean(Issue.class));
//        List<IssueDto> issueList = query.getResultList();
//        session.getTransaction().commit();
//        return  issueList;
//    }
//
//    @Override
//    public IssueDto get(long id) {
//        return null;
//    }
//
//    @Override
//    public void save(IssueDto issueDto) {
//
//    }
//
//    @Override
//    public void delete(long id) {
//
//    }
//}
