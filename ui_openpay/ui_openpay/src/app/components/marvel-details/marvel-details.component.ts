import { Component, OnInit } from '@angular/core';
import { MarvelService } from 'src/app/services/marvel.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-tutorial-details',
  templateUrl: './marvel-details.component.html',
  styleUrls: ['./marvel-details.component.css']
})
export class MarvelDetailsComponent implements OnInit {
  currentMarvel = null;
  message = '';

  constructor(
    private tutorialService: MarvelService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.message = '';
    this.getTutorial(this.route.snapshot.paramMap.get('id'));
  }

  getTutorial(id) {
    this.tutorialService.get(id)
      .subscribe(
        data => {
          this.currentMarvel = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

}
