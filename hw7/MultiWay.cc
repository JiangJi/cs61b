#include <iostream>
#include <queue>
#include <cassert>
#include <fstream>
#include <sstream>
using namespace std;
class Stream
{
 private:
  istream *in;
  string cur;
 public:
  Stream(istream *in)
      :in(in)
  {
    if(!empty())
    {
      (*in)>>cur;
    }
  }
  bool empty() const
  {
    return (*in).peek() == -1;
  }
  string current() const
  {
    return cur;
  }
  string next()
  {
    assert(!empty());
    string res = current();
    (*in)>>cur;
    return res;
  }
  bool operator<(const Stream &rhs) const
  {
    return current() > rhs.current();
  }
};
void mergeN(Stream inFiles[],int N)
{
  priority_queue<Stream> pq;
  for(int i=0;i<N;i++)
  {
    if(!inFiles[i].empty())
    {
      pq.push(inFiles[i]);
    }
  }
  while(!pq.empty())
  {
    Stream ss = pq.top();
    pq.pop();
    cout<<ss.next()<<endl;
    if(!ss.empty())
    {
      pq.push(ss);
    }
  }
}
int main()
{
  ifstream is1("input1");
  ifstream is2("input2");
  ifstream is3("input3");
  Stream ss[3] = {&is1,&is2,&is3};
  mergeN(ss,3);
}
