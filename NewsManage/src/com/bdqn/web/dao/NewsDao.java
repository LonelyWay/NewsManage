package com.bdqn.web.dao;


import org.news.entity.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NewsDao extends BaseDao{

    Connection conn = null;
    PreparedStatement ppst = null;
    ResultSet rs = null;
    List<News> list = new ArrayList<News>();

    //分页查询方法
    public List<News> getList(int start, int pagesize){
        String sql = "SELECT nid,ntid,ntitle,nauthor,NCREATEDATE,(SELECT tname FROM topic T WHERE T.tid = N.ntid) TNAME FROM news N limit ?,?";
        rs = executeQuery(sql,start,pagesize);
        try {
            while (rs.next()){
                News news = new News();
                news.setNid(rs.getInt(1));
                news.setNtid(rs.getInt(2));
                news.setNtitle(rs.getString(3));
                news.setNauthor(rs.getString(4));
                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getDate(5));
                news.setNcreatedate(date);
                news.setNtopic(rs.getString(6));
                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //查询总条数
    public int getAllCount(){
        String sql = "select * from news";
        int count = 0;
        rs = executeQuery(sql);
        try {
            while (rs.next()){
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int add(int ntid,String ntitle,String date,String ncontent,String author,String summary){
        int count = 0;
        String sql = "insert into news(ntid,ntitle,nauthor,ncreatedate,ncontent,nsummary) values(?,?,?,?,?,?)";
        count = executeUpdate(sql,ntid,ntitle,author,date,ncontent,summary);
        return count;
    }

    public int update(int ntid,String title,String author,String content,String summary,int nid){
        String sql = "update news set ntid = ?,ntitle = ?,nauthor = ?,ncontent = ?,nmodifydate = now(),nsummary = ? where nid = ?";
        int count = 0;
        count = executeUpdate(sql,ntid,title,author,content,summary,nid);
        return count;
    }

    public int delete(int tid){
        String sql = "delete from news where nid = ?";
        int count = 0;
        count = executeUpdate(sql,tid);
        return count;
    }
    
    public News selectNews(int nid){
        String sql = "SELECT nid,ntid,ntitle,nauthor,ncontent,nsummary,(SELECT tname FROM topic T WHERE T.tid = N.ntid) TNAME FROM news N where nid = ?";
        rs = executeQuery(sql,nid);
        try {
            if (rs.next()){
                News news = new News();
                news.setNid(rs.getInt(1));
                news.setNtid(rs.getInt(2));
                news.setNtitle(rs.getString(3));
                news.setNauthor(rs.getString(4));
                news.setNcontent(rs.getString(5));
//                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getDate(6));
//                news.setNmodifydate(date);
                news.setNsummary(rs.getString(6));
                news.setNtopic(rs.getString(7));
                return news;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
