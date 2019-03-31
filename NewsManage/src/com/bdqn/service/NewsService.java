package com.bdqn.service;

import com.bdqn.web.dao.NewsDao;
import com.bdqn.zmj.util.Page;
import org.news.entity.News;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ChaW
 * Date: 2019/3/27
 * Time: 12:52
 * Description: No Description
 */
public class NewsService {

    NewsDao dao = new NewsDao();

    public Page<News> list(int curpage,int pagesize){
        int start = (curpage - 1) * pagesize;
        List<News> list = dao.getList(start,pagesize);
        Page<News> p = new Page<News>();
        int count = dao.getAllCount();
        p.setMsg("请求数据成功！");
        p.setCount(count);
        p.setData(list);
        return p;
    }

    public int add(int tid,String title,String date,String content,String author,String summary){
        int count = 0;
        count = dao.add(tid,title,date,content,author,summary);
        return count;
    }

    public int update(String title,String author,String content,String modigydate,String summary,int tid){
        int count = 0;
        count = dao.executeUpdate(title,author,content,modigydate,summary,tid);
        return count;
    }

    public int delete(int nid){
        int count = 0;
        count = dao.delete(nid);
        return 0;
    }
}
