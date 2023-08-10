import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMarvelComponent } from './add-marvel.component';

describe('AddTutorialComponent', () => {
  let component: AddMarvelComponent;
  let fixture: ComponentFixture<AddMarvelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddMarvelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMarvelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
