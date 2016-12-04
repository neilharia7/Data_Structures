/*
Input Format. Input contains one string 𝑆 which consists of big and small latin letters, digits, punctuation
marks and brackets from the set []{}().
Constraints. The length of 𝑆 is at least 1 and atmost 10^5.
Output Format. If the code in 𝑆 uses brackets correctly, output “Success" (without the quotes). Otherwise,
output the 1-based index of the first unmatched closing bracket, and if there are no unmatched closing
brackets, output the 1-based index of the first unmatched opening bracket.
*/
#include<bits/stdc++.h>
using namespace std;

struct Parentheses{
	Paranthesee( int type, int pos):
	type(type),
	pos(pos){}
	bool ArePair( char bracket){
		if( type == '[' && bracket == ']') return true;
		if( type == '{' && bracket == '}') return true;
		if( type == '(' && bracket == ')') return true;
		return false;
	}
	char type;
	int pos;
};
int main (){
	string str;
	cin>>str;
	int flag = -1;
	
	stack <Parentheses> S;
	if (str.length() <= 1){
		cout<< "-1";
		return 0;
	}
	for (int pos = 0; pos < str.length(); pos++){
		char next = str[pos];
		if (next == '(' || next == '[' || next == '{') {
			S.push(Parentheses(next, pos));
		}
		if (next == ')' || next == ']' || next == '}') {
			if (!S.empty() && S.top().ArePair(next)) {
				S.pop();
			}
			else {
				cout<<pos + 1;
				return 0;
			}
		}
	}
	if (S.empty() && flag == -1) {
		cout<< "Success";
	}
	else if (flag == -1) {
		cout<<S.top.pos+1;
	}
	else {
		cout<<flag + 1;
	}
	return 0;
}
