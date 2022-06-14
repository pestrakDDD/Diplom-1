export class FeedModel {
  id: number | null;
  name: string;
  description: string;

  constructor(name: string, description: string, id: number) {
    this.id = id;
    this.name = name;
    this.description = description;
  }
}
