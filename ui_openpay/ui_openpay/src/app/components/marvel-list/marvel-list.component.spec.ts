import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MarvelListComponent } from './marvel-list.component';

describe('TutorialsListComponent', () => {
  let component: MarvelListComponent;
  let fixture: ComponentFixture<MarvelListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MarvelListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MarvelListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
