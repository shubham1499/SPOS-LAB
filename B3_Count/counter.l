%{

  int cnt_line,cnt_words,cnt_characters;
%}

%%
\n {cnt_line++;cnt_characters++;}
[^ \t\n]+ {cnt_words++;cnt_characters = cnt_characters + yyleng;}
. {cnt_characters++;}
%%

int yywrap(){
return 1;
}

int main(int argc,char *argv[]){
  yyin = fopen(argv[1],"r");
  yylex();
  printf("No. of Lines=%d\n",cnt_line);
  printf("No. of Words=%d\n",cnt_words);
  printf("No. of Characters=%d\n",cnt_characters);
}
