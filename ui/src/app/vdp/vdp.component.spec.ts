import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VdpComponent } from './vdp.component';

describe('VdpComponent', () => {
  let component: VdpComponent;
  let fixture: ComponentFixture<VdpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VdpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VdpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
