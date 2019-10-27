import {Directive, ElementRef} from '@angular/core';

@Directive({
  selector: '[appBack]'
})
export class BackgroundDirective {

  constructor(private el: ElementRef) {
    console.log(el);
  }

}
