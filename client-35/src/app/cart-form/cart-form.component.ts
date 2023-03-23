import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { map } from 'rxjs/operators';
import { CartService } from '../cart.service';
import { Cart } from '../models';

@Component({
  selector: 'app-cart-form',
  templateUrl: './cart-form.component.html',
  styleUrls: ['./cart-form.component.css']
})
export class CartFormComponent implements OnInit{

  cartForm!: FormGroup;
  itemsArray!: FormArray;

  constructor( private fb: FormBuilder,
               private cartService: CartService){}

  ngOnInit(): void {
    this.itemsArray = this.fb.array([]);
    this.cartForm = this.createForm();
  }

  private createForm() : FormGroup {
    return this.fb.group({
      name: this.fb.control<string>("aaa"),
      email: this.fb.control<string>("aaa"),
      items: this.itemsArray
    })
  }

  processForm() {
    const formValue = this.cartForm.value as Cart
    console.log(JSON.stringify(formValue));
    // console.log("EASY --> ", formValue.email);
    // console.log("IRRITATING --> ", this.cartForm.get("name")?.value);

    // call cart service
    this.cartService.postForm$(formValue)
    .pipe(map( x => x as Cart))
    .subscribe( x => alert(x.orderId)) // return???
    
    // send cart data to service
  }

  onAdd() {
    const grp = this.fb.group({
      name: this.fb.control<string>("aaa"),
      quantity: this.fb.control<number>(0)
    })

    this.itemsArray.push(grp);
  }

  onDelete(idx: number) {
    // remove smth from array
    this.itemsArray.removeAt(idx);
  }

}
