package dev.dipanshu.livescore.service;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class CricInfoService {

    public String getLatestScore() {
        try {
            URL feedUrl = new URL("https://www.espncricinfo.com/rss/livescores.xml");
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));

            StringBuilder scores = new StringBuilder();
            for (SyndEntry entry : feed.getEntries()) {
                scores.append(entry.getTitle()).append("\n");
            }
            return scores.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to retrieve score: " + e.getMessage();
        }
    }
}
