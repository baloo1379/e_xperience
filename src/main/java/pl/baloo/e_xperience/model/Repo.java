package pl.baloo.e_xperience.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repo implements Comparable<Repo> {


    private final String name;

    private final ZonedDateTime pushed_at;

    public Repo(@JsonProperty("name") String name, @JsonProperty("pushed_at") String pushed_at) {
        this.name = name;
        this.pushed_at = ZonedDateTime.ofInstant(Instant.parse(pushed_at), ZoneOffset.UTC);
    }

    public String getName() {
        return name;
    }

    public ZonedDateTime getPushed_at() {
        return pushed_at;
    }

    @Override
    public int compareTo(Repo o) {
        return o.getPushed_at().compareTo(this.pushed_at);
    }
}
