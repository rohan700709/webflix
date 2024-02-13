import { TestBed } from '@angular/core/testing';

import { SearchmovieService } from './searchmovie.service';

describe('SearchmovieService', () => {
  let service: SearchmovieService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SearchmovieService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
