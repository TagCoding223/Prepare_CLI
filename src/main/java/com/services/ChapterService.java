package com.services;

import com.entities.Chapter;

import java.util.List;

public interface ChapterService {
    Chapter createChapter(Chapter chapter);
    Chapter findChapterById(int id);
    Chapter updateChapter(Chapter chapter);
    String deleteChapter(int id);
    List<Chapter> getAllChapters();
}
