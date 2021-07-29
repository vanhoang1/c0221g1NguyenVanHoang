export class CustomerType {
  public constructor(init?: Partial<CustomerType>) {
    Object.assign(this, init);
  }
  id: number;
  name: string;
}
