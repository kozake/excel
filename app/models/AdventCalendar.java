package models;

import javax.persistence.Entity;

import play.db.jpa.Model;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@Entity
public class AdventCalendar extends Model {

    public String category;
    public String name;
    public String url;

    @OnApplicationStart
    public static class BootLoader extends Job<Object> {
        @Override
        public void doJob() {
            Fixtures.delete(AdventCalendar.class);
            Fixtures.loadModels("initial-advent_calendar-data.yml");
        }
    }
}
