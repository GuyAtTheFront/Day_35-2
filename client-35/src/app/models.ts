export interface Cart {
    orderId?: string;
    name: string;
    email: string;
    items: Item[];
}

export interface Item{
    name: string;
    quantity: number;
}

// export interface ModifiedCart extends Cart {
//     orderId: string;
// }