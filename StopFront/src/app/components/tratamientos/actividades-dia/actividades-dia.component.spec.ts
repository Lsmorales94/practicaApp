import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActividadesDiaComponent } from './actividades-dia.component';

describe('ActividadesDiaComponent', () => {
  let component: ActividadesDiaComponent;
  let fixture: ComponentFixture<ActividadesDiaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActividadesDiaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActividadesDiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
