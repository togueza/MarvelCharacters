import { TestBed } from '@angular/core/testing';

import { MarvelService } from './marvel.service';

describe('TutorialService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MarvelService = TestBed.get(MarvelService);
    expect(service).toBeTruthy();
  });
});
