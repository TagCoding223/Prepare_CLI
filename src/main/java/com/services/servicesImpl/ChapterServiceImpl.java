package com.services.servicesImpl;

import com.dao.ChapterDao;
import com.dao.daoImpl.ChapterDaoImpl;
import com.entities.Chapter;
import com.services.ChapterService;

import java.util.List;

public class ChapterServiceImpl implements ChapterService {

    private final ChapterDao chapterDao;

    ChapterServiceImpl(){
        chapterDao = new ChapterDaoImpl();
    }

    @Override
    public Chapter createChapter(Chapter chapter) {
        return chapterDao.createChapter(chapter);
    }

    @Override
    public Chapter findChapterById(int id) {
        return chapterDao.findChapterById(id);
    }

    @Override
    public Chapter updateChapter(Chapter chapter) {
        return chapterDao.updateChapter(chapter);
    }

    @Override
    public String deleteChapter(int id) {
        return chapterDao.deleteChapter(id);
    }

    @Override
    public List<Chapter> getAllChapters() {
        return chapterDao.getAllChapters();
    }
}
