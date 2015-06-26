#include <iostream>
#include <string>
using namespace std;
class Animal
{
 public:
  Animal()
  {
    name = "SuperAnimal";
  }
  virtual void speak()
  {
    cout<<name<<endl;
  }
 private:
  string name;
};
class Fox : public Animal
{
 private:
  string name;
 public:
  Fox()
  {
  }
  Fox(string s)
  {
    name = s;
  }
  void speak() override
  {
    cout<<"Ringding "<<name<<endl;
  }
  void bite()
  {
    cout<<"Bite"<<endl;
  }
};
int main()
{
  Animal* f0 = new Fox("god");
  Animal* f1 = new Animal();
  dynamic_cast<Fox*>(f1)->bite();
}
