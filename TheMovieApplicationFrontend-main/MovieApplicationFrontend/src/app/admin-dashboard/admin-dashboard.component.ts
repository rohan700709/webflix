import { Component, OnInit } from '@angular/core';
import { count } from 'console';
import { PlaylistServiceService } from '../service/playlist-service/playlist-service.service';
import { UserService } from '../service/user-service/user.service';
import { ToastService } from '../toast.service';
import { User } from '../User';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  user: User[];
  count: number;
  playlistCount: number;
  constructor(private userService: UserService, private playlistService: PlaylistServiceService, public toastService: ToastService) { }

  ngOnInit(): void {

    this.getAllUserList();
    this.getAllUserCount();
  }

  getAllUserCount() {
    this.userService.getUserCount().subscribe(
      response => {
        this.count = response;
        console.log(this.count);
      }
    )
  }
  getAllUserList() {

    this.userService.getAllUser().subscribe(
      response => {
        this.user = response;
        console.log(this.user);

      }
    )

  }

  deletedSuccess() {
    this.toastService.show('Deleted Successfully', { classname: 'bg-success text-light', delay: 2000 });
  }

  deleteUserFromList(userEmail: string) {

    this.userService.deleteUser(userEmail).subscribe(
      (response: any) => {
        this.deletedSuccess()
        // alert("succesfully deleted");
        console.log("successfully deleted");

        this.ngOnInit();
      },
      error => {
        console.log(error);
      }
    )
  }

  // getPlaylistCount()
  // {
  //   this.playlistService.getPlaylistCount().subscribe(data => {
  //     this.playlistCount = data;
  //   })
  // }

}
