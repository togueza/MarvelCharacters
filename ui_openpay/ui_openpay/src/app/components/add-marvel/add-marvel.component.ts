import { Component, OnInit } from '@angular/core';
import { MarvelService } from 'src/app/services/marvel.service';

@Component({
  selector: 'app-add-tutorial',
  templateUrl: './add-marvel.component.html',
  styleUrls: ['./add-marvel.component.css']
})
export class AddMarvelComponent implements OnInit {
  character = {
    title: '',
    description: '',
    published: false
  };
  submitted = false;

  constructor(private marvelService: MarvelService) { }

  ngOnInit() {
  }

  saveMarvelCharacter() {
    const data = {
      title: this.character.title,
      description: this.character.description
    };

    this.marvelService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newMarvelCharacter() {
    this.submitted = false;
    this.character = {
      title: '',
      description: '',
      published: false
    };
  }

}
