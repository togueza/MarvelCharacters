import { Component, OnInit } from '@angular/core';
import { MarvelService } from '../../services/marvel.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-marvel-details',
  templateUrl: './marvel-details.component.html',
  styleUrls: ['./marvel-details.component.css']
})
export class MarvelDetailsComponent implements OnInit {
  currentMarvel = null;
  message = '';

  constructor(
    private marvelService: MarvelService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.message = '';
    this.getCharacter(this.route.snapshot.paramMap.get('id'));
  }

  getCharacter(id) {
    this.marvelService.get(id)
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
