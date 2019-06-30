package it.akademija.webscrapper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowUnit {
    public String showName;
    public String showTime;
    public String channelName;
}
