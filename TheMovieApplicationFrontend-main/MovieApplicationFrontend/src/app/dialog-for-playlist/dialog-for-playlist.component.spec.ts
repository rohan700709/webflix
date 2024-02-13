import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogForPlaylistComponent } from './dialog-for-playlist.component';

describe('DialogForPlaylistComponent', () => {
  let component: DialogForPlaylistComponent;
  let fixture: ComponentFixture<DialogForPlaylistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogForPlaylistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogForPlaylistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
