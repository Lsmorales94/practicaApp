import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CigarrillosComponent } from './cigarrillos.component';

describe('CigarrillosComponent', () => {
  let component: CigarrillosComponent;
  let fixture: ComponentFixture<CigarrillosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CigarrillosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CigarrillosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
