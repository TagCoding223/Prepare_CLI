package com.dao;

import com.entities.Chapter;

import java.util.List;

public interface ChapterDao {
    Chapter createChapter(Chapter chapter);
    Chapter findChapterById(long id);
    Chapter updateChapter(Chapter chapter);
    String deleteChapter(int id);
    List<Chapter> getAllChapters();
}
