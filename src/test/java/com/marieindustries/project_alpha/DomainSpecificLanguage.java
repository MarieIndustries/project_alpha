package com.marieindustries.project_alpha;

import org.springframework.stereotype.Service;

@Service
public class DomainSpecificLanguage {
    public final BddJokesService bddJokesService;
    public final BddMockMvcService bddMockMvcService;

    public DomainSpecificLanguage(final BddJokesService bddJokesService, final BddMockMvcService bddMockMvcService){
        this.bddJokesService = bddJokesService;
        this.bddMockMvcService = bddMockMvcService;
    }
}
