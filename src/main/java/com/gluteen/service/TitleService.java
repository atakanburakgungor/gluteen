package com.gluteen.service;

import com.gluteen.domain.Title;
import com.gluteen.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yusufaslan on 31.05.2017.
 */
@Service
public class TitleService {

    @Autowired
    private TitleRepository titleRepository;

    public Title getTitleById(Long id)
    {
        return titleRepository.findById(id);
    }

    public List<Title> getTitlesOrderByDate()
    {
        return titleRepository.findAllByOrOrderByTitleCreated();
    }

    // public Title getTitlesByPerson(){} buna gerek yok çünkü kişilerin açtığı titleları değil postları görmek isteyeceğiz

    public void updateTitle(Title title)
    {
       titleRepository.updateTitle(title.getId(), title.getTitleBody());
    }

    public Title createTitle(Title title)
    {
       return titleRepository.save(title);
    }
    public void deleteTitle(Long id)
    {
        titleRepository.deleteTitleById(id);
    }
}
