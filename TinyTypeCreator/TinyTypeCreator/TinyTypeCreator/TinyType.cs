using System;

namespace TinyTypeCreator
{
    public class TinyType
    {    
        public Type Type { get; set; }
        public string Name { get;  set; }

        public TinyType(string name, Type type)
        {
            Name = name;
            Type = type;
        }

        public override string ToString()
        {
            return string.Format("{0} - {1}", Name, Type.Name);
        }

        public override bool Equals(object obj)
        {
            if (obj is TinyType)
            {
                var tmp = (TinyType) obj;
                return tmp.Name == Name && tmp.Type == Type;
            }

            return false;
        }

        // http://stackoverflow.com/a/263416/1864167
        public override int GetHashCode()
        {
            unchecked
            {
                int hash = 17;
                if(Name != null) { hash = hash * 29 + Name.GetHashCode(); }
                if(Type != null) { hash = hash * 29 + Type.GetHashCode(); }
                return hash;
            }
        }
    }
}
