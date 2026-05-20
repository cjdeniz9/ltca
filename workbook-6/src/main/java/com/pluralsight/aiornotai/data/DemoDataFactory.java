package com.pluralsight.aiornotai.data;

import com.pluralsight.aiornotai.models.Image;
import com.pluralsight.aiornotai.models.Multimedia;
import com.pluralsight.aiornotai.models.Text;
import com.pluralsight.aiornotai.models.Video;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DemoDataFactory {

    public List<Multimedia> createDemoFiles() {
        List<Multimedia> files = new ArrayList<>();

        files.add(new Image("ai-generated-cat.png", LocalDate.of(2023, 6, 10)));
        files.add(new Image("holiday-photo.png", LocalDate.of(2023, 6, 10)));

        files.add(new Text("AI-essay.txt", LocalDate.of(2023, 2, 1)));
        files.add(new Text("school-notes.txt", LocalDate.of(2023, 2, 1)));

        files.add(new Video("ai-movie-trailer.mp4", LocalDate.of(2025, 1, 20)));
        files.add(new Video("birthday-video.mp4", LocalDate.of(2025, 1, 20)));

        return files;
    }
}