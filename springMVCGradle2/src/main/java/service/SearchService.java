package service;

import org.springframework.stereotype.Component;

@Component
public class SearchService {
	public SearchResult search(SearchCommand command) {
		System.out.println("SearchService.search 실행");
		return new SearchResult();
	}

}
